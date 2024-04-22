package dev.xxj.wechatapi.web.repo;

import dev.xxj.wechatapi.web.data.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {

}