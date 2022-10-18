/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.exceptions.NonexistentEntityException;
import entities.exceptions.PreexistingEntityException;
import entities.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
//agregar:
import javax.persistence.Persistence;

/**
 *
 * @author rodri
 */
public class ConcecionariaJpaController implements Serializable {

    public ConcecionariaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    // Constructor registro
    
    
    private UserTransaction utx = null;
    
    //private EntityManagerFactory emf = null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaToday");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Concecionaria concecionaria) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(concecionaria);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findConcecionaria(concecionaria.getMarca()) != null) {
                throw new PreexistingEntityException("Concecionaria " + concecionaria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Concecionaria concecionaria) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            concecionaria = em.merge(concecionaria);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = concecionaria.getMarca();
                if (findConcecionaria(id) == null) {
                    throw new NonexistentEntityException("The concecionaria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Concecionaria concecionaria;
            try {
                concecionaria = em.getReference(Concecionaria.class, id);
                concecionaria.getMarca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The concecionaria with id " + id + " no longer exists.", enfe);
            }
            em.remove(concecionaria);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Concecionaria> findConcecionariaEntities() {
        return findConcecionariaEntities(true, -1, -1);
    }

    public List<Concecionaria> findConcecionariaEntities(int maxResults, int firstResult) {
        return findConcecionariaEntities(false, maxResults, firstResult);
    }

    private List<Concecionaria> findConcecionariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Concecionaria.class));
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

    public Concecionaria findConcecionaria(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Concecionaria.class, id);
        } finally {
            em.close();
        }
    }

    public int getConcecionariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Concecionaria> rt = cq.from(Concecionaria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
