package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel) {
        InhousePart inhousepart = new InhousePart();
        theModel.addAttribute("inhousepart", inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("inhousepart", part);

        if(part.getInv() < part.getMinInv()) {
            bindingResult.rejectValue("inv", "LowInventory", "Inv must be greater than or equal to minInv");
            return "InhousePartForm";
        }
        if(part.getInv() > part.getMaxInv()) {
            bindingResult.rejectValue("inv", "HighInventory", "Inv must be less than or equal to maxInv");
            return "InhousePartForm";
        }
        if(bindingResult.hasErrors()) {
            return "InhousePartForm";
        }
        else {

        InhousePartService repo = context.getBean(InhousePartServiceImpl.class);
        InhousePart  ip= repo.findById((int) part.getId());
        if (ip!= null) part.setProducts(ip.getProducts());
        repo.save(part);
        return "confirmationaddpart";
    }
}
}
