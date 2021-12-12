/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import muestra.jpa.personas.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import muestra.jpa.persistencia.exceptions.NonexistentEntityException;
import muestra.jpa.personas.Empleado;

/**
 *
 * @author profl
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EmpleadoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("personaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        if (empleado.getVentas() == null) {
            empleado.setVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedVentas = new ArrayList<Venta>();
            for (Venta ventasVentaToAttach : empleado.getVentas()) {
                ventasVentaToAttach = em.getReference(ventasVentaToAttach.getClass(), ventasVentaToAttach.getIdVenta());
                attachedVentas.add(ventasVentaToAttach);
            }
            empleado.setVentas(attachedVentas);
            em.persist(empleado);
            for (Venta ventasVenta : empleado.getVentas()) {
                Empleado oldVendedorOfVentasVenta = ventasVenta.getVendedor();
                ventasVenta.setVendedor(empleado);
                ventasVenta = em.merge(ventasVenta);
                if (oldVendedorOfVentasVenta != null) {
                    oldVendedorOfVentasVenta.getVentas().remove(ventasVenta);
                    oldVendedorOfVentasVenta = em.merge(oldVendedorOfVentasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getIdPersona());
            List<Venta> ventasOld = persistentEmpleado.getVentas();
            List<Venta> ventasNew = empleado.getVentas();
            List<Venta> attachedVentasNew = new ArrayList<Venta>();
            for (Venta ventasNewVentaToAttach : ventasNew) {
                ventasNewVentaToAttach = em.getReference(ventasNewVentaToAttach.getClass(), ventasNewVentaToAttach.getIdVenta());
                attachedVentasNew.add(ventasNewVentaToAttach);
            }
            ventasNew = attachedVentasNew;
            empleado.setVentas(ventasNew);
            empleado = em.merge(empleado);
            for (Venta ventasOldVenta : ventasOld) {
                if (!ventasNew.contains(ventasOldVenta)) {
                    ventasOldVenta.setVendedor(null);
                    ventasOldVenta = em.merge(ventasOldVenta);
                }
            }
            for (Venta ventasNewVenta : ventasNew) {
                if (!ventasOld.contains(ventasNewVenta)) {
                    Empleado oldVendedorOfVentasNewVenta = ventasNewVenta.getVendedor();
                    ventasNewVenta.setVendedor(empleado);
                    ventasNewVenta = em.merge(ventasNewVenta);
                    if (oldVendedorOfVentasNewVenta != null && !oldVendedorOfVentasNewVenta.equals(empleado)) {
                        oldVendedorOfVentasNewVenta.getVentas().remove(ventasNewVenta);
                        oldVendedorOfVentasNewVenta = em.merge(oldVendedorOfVentasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleado.getIdPersona();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<Venta> ventas = empleado.getVentas();
            for (Venta ventasVenta : ventas) {
                ventasVenta.setVendedor(null);
                ventasVenta = em.merge(ventasVenta);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
