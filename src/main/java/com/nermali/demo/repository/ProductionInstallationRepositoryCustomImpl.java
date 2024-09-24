package com.nermali.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


import com.nermali.demo.model.ProductionInstallation;
import com.nermali.demo.model.QProductionInstallation;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

public class ProductionInstallationRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductionInstallationRepositoryCustom {

    public ProductionInstallationRepositoryCustomImpl() {
        super(ProductionInstallation.class);
    }

    public Page<ProductionInstallation> findByCriteria(final ProductionInstallationSearchCriteria searchCriteria, final Pageable pageable) {

        QProductionInstallation productionInstallation = QProductionInstallation.productionInstallation;
        BooleanBuilder builder = new BooleanBuilder();
        if (searchCriteria.getName() != null) {
            builder.and(productionInstallation.name.eq(searchCriteria.getName()));
        }
        if (searchCriteria.getMinOutput() != null) {
            builder.and(productionInstallation.outputPower.goe(searchCriteria.getMinOutput()));
        }
        if (searchCriteria.getMaxOutput() != null) {
            builder.and(productionInstallation.outputPower.loe(searchCriteria.getMaxOutput()));
        }
        JPAQuery<ProductionInstallation> query = new JPAQuery<>(getEntityManager());
        query.from(productionInstallation).where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());
        List<ProductionInstallation> result = query.fetch();
        return new PageImpl<>(result, pageable, query.fetchCount());
    }
}
