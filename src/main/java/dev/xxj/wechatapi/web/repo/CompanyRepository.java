package dev.xxj.wechatapi.web.repo;

import dev.xxj.wechatapi.web.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

}