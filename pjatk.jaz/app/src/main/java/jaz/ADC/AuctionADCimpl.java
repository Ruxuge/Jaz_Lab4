package jaz.ADC;

import jaz.entity.AuctionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class AuctionADCimpl implements AuctionADC
{
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public List<AuctionEntity> getAuctionList()
    {
        return em.createQuery("FROM AuctionEntity ORDER BY id ASC ").getResultList();
    }

    @Override
    @Transactional
    public Optional<AuctionEntity> getAuctionById(Long auctionId)
    {
        return Optional.ofNullable(em.find(AuctionEntity.class, auctionId));
    }

    @Override
    @Transactional
    public void save(AuctionEntity auctionEntity)
    {
        if (auctionEntity.getId() == null)
        {
            em.persist(auctionEntity);
        } else {
            em.merge(auctionEntity);
        }
    }

    @Override
    @Transactional
    public void delete(AuctionEntity auctionEntity)
    {
        if (auctionEntity.getId() != null)
        {
            em.remove(em.find(AuctionEntity.class, auctionEntity.getId()));
        }
        else
        {
            System.out.println("lel");
        }
    }
}