package com.stingtech.rms.controller;

import com.stingtech.rms.entity.Repair;
import com.stingtech.rms.entity.Terminal;
import com.stingtech.rms.service.RepairService;
import com.stingtech.rms.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
//@RequestMapping("/repair")
public class RepairController {

    private final RepairService repairService;
    private final TerminalService terminalService;
    String redirect = "redirect:/repair/repairs";

    @Autowired
    public RepairController(RepairService repairService, TerminalService terminalService) {
        this.repairService = repairService;
        this.terminalService = terminalService;
    }

    @GetMapping("/repair/repairs")
    public String getRepairs(Model model){
        model.addAttribute("terminals", terminalService.getAllTerminals());
        model.addAttribute("repairs", repairService.getRepairs());
        return "repair/repairs";
    }

    @GetMapping("/repair/repairs/new")
    public String createRepairForm(Model model){
        List<Terminal> terminals = terminalService.getAllTerminals();
        Repair repair = new Repair();
        model.addAttribute("terminals", terminals);
        model.addAttribute("repair", repair);
        return "repair/create-repair";
    }

    @PostMapping("/repair/repairs")
    public String saveRepair(@ModelAttribute Repair repair){
        repairService.addRepair(repair);
        return redirect;
    }

    @GetMapping("/repair/repairs/{id}")
    public String deleteRepair(@PathVariable Long repairId){
        repairService.deleteRepair(repairId);
        return redirect;
    }

    /**
     * handles GET requests to the /repairs/edit/{id} URL, retrieves a repair by its ID using a service class,
     * adds the vendor to the model, and returns the logical view name "edit-repair" to render the response
     * @param repairId
     * @param model
     * @return edit-repair thymeleaf page
     */
    @GetMapping("/repair/repairs/edit/{repairId}")
    public String editRepairForm(@PathVariable Long repairId, Model model){
        Repair repair = repairService.getRepairById(repairId)
                .orElseThrow(() -> new RuntimeException("Repair not found"));
        model.addAttribute("repair", repair);
        return "repair/edit-repair";
    }

    /**
     * handles requests POSTed on submission of editing a repair form
     * on edit-repair page. Saves the edited repair in DB
     * @param repairId
     * @return redirects back to repairs page
     */
    @PostMapping("/repair/repairs/{id}")
    public String updateRepair(@PathVariable Long repairId){
        repairService.updateRepair(repairId);
        return redirect;
    }
}
