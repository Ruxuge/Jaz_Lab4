package jaz.ADC;

import jaz.entity.AuctionEntity;

import java.util.List;
import java.util.Optional;

public interface AuctionADC
{
    List<AuctionEntity> getAuctionList();
    Optional<AuctionEntity> getAuctionById(Long auctionId);
    void save(AuctionEntity auctionEntity);
    void delete(AuctionEntity auctionEntity);
}
