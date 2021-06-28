package com.epam.training.microservices.monolithic.web.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.model.delivery.DeliveryLine;
import com.epam.training.microservices.monolithic.service.CrudService;
import com.epam.training.microservices.monolithic.service.delivery.DeliveryService;
import com.epam.training.microservices.monolithic.service.drug.DrugService;
import com.epam.training.microservices.monolithic.service.pharmacy.PharmacyService;
import com.epam.training.microservices.monolithic.web.crud.CrudController;
import com.epam.training.microservices.monolithic.web.crud.SelectItem;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllSupport;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.all.column.LinkColumnModel;
import com.epam.training.microservices.monolithic.web.crud.all.column.TextColumnModel;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/delivery")
public class DeliveryController implements ViewAllSupport<Delivery> {
  @Autowired
  private DeliveryService deliveryService;

  @Autowired
  private DeliveryTransformer deliveryTransformer;

  @Override
  public CrudService getService() {
    return deliveryService;
  }

  @Override
  public ViewAllTemplateParams getViewAllTemplateParams() {
    return ViewAllTemplateParams.builder()
        .title("Delivery")
        .column(new LinkColumnModel<>("Address", Delivery::getAddressLine,
            d -> "/delivery/" + d.getId()))
        .column(new TextColumnModel<Delivery>("Status", d -> d.getStatus().name()))
        .build();
  }

  @GetMapping("/{id}")
  public ModelAndView editDelivery(ModelAndView modelAndView, @PathVariable("id") Long id) {
    modelAndView.setViewName("delivery/edit");
    modelAndView.addObject("delivery", deliveryTransformer.toModel(id));

    return modelAndView;
  }
}
