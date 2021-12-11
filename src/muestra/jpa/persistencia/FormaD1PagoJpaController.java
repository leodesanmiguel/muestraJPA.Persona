/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestra.jpa.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import muestra.jpa.persistencia.exceptions.NonexistentEntityException;
import muestra.jpa.personas.FormaD1Pago;

/**
 *
 * @author profl
 */
public class FormaD1PagoJpaController implements Serializable {

    public FormaD1PagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FormaD1Pago formaD1Pago) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(formaD1Pago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FormaD1Pago formaD1Pago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            formaD1Pago = em.merge(formaD1Pago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = formaD1Pago.getIdForma();
                if (findFormaD1Pago(id) == null) {
                    throw new NonexistentEntityException("The formaD1Pago with id " + id + " no longer exists.");
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
            FormaD1Pago formaD1Pago;
            try {
                formaD1Pago = em.getReference(FormaD1Pago.class, id);
                formaD1Pago.getIdForma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formaD1Pago with id " + id + " no longer exists.", enfe);
            }
            em.remove(formaD1Pago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FormaD1Pago> findFormaD1PagoEntities() {
        return findFormaD1PagoEntities(true, -1, -1);
    }

    public List<FormaD1Pago> findFormaD1PagoEntities(int maxResults, int firstResult) {
        return findFormaD1PagoEntities(false, maxResults, firstResult);
    }

    private List<FormaD1Pago> findFormaD1PagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FormaD1Pago.class));
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

    public FormaD1Pago findFormaD1Pago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FormaD1Pago.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormaD1PagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FormaD1Pago> rt = cq.from(FormaD1Pago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
