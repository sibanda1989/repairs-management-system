package com.stingtech.rms.controller;

import com.stingtech.rms.entity.Repair;
import com.stingtech.rms.entity.Terminal;
import com.stingtech.rms.service.RepairService;
import com.stingtech.rms.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/repair")
public class RepairController {

    private final RepairService repairService;
    private final TerminalService terminalService;
    String redirect = "redirect:/repairs";

    @Autowired
    public RepairController(RepairService repairService, TerminalService terminalService) {
        this.repairService = repairService;
        this.terminalService = terminalService;
    }

    @GetMapping("/repairs")
    // *TO DO* is this not a duplication, since app is listening at "/repairs" at class level?
    public String getRepairs(Model model){
        List<Repair> repairs = repairService.getRepairs();
        model.addAttribute("repairs", repairs);
        return redirect;
    }

    @GetMapping("/repairs/new")
    public String createRepairForm(Model model){
        List<Terminal> terminals = terminalService.getAllTerminals();
        Repair repair = new Repair();
        model.addAttribute("terminals", terminals);
        model.addAttribute("repair", repair);
        return "create-repair";
    }

    @PostMapping("/repairs")
    public String saveRepair(@ModelAttribute Repair repair){
        repairService.addRepair(repair);
        return redirect;
    }

    @GetMapping("/repairs/{id}")
    public String deleteRepair(@PathVariable Long repairId){
        repairService.deleteRepair(repairId);
        return redirect;
    }

    @GetMapping("/repairs/edit/{id}")
    public String editRepairForm(@PathVariable Long repairId, Model model){
        /*
        this method handles GET requests to the /repairs/edit/{id} URL, retrieves a repair by its ID using a service class,
        adds the vendor to the model, and returns the logical view name "edit-repair" to render the response
         */
        model.addAttribute("repair", repairService.getRepairById(repairId));
        return "edit-repair";
    }

    @PostMapping("repairs/{id}")
    public String updateRepair(@PathVariable Long repairId){
        repairService.updateRepair(repairId);
        return redirect;
    }
}
