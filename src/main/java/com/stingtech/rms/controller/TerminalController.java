package com.stingtech.rms.controller;

import com.stingtech.rms.entity.Terminal;
import com.stingtech.rms.entity.TerminalModel;
import com.stingtech.rms.service.ModelService;
import com.stingtech.rms.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class TerminalController {

    private final TerminalService terminalService;
    private final ModelService modelService;

    @Autowired
    public TerminalController(TerminalService terminalService, ModelService modelService) {
        this.terminalService = terminalService;
        this.modelService = modelService;
    }

    @GetMapping("/terminals")
    public String getTerminalsList(Model model){
        model.addAttribute("terminals", terminalService.getAllTerminals());
        return "terminals";
    }
    @GetMapping("terminal/new")
    public String createTerminalForm(Model model){
        /*
        This method creates an object used to populate the form, by using fields from the entity class
         */
        List<TerminalModel> models = modelService.getAllModels();
        Terminal terminal = new Terminal();
        model.addAttribute("models", models);
        model.addAttribute("terminal", terminal);
        return "create-terminal";
    }

    @PostMapping("terminals")
    public String addTerminal(@ModelAttribute("terminal") Terminal terminal){
        terminalService.saveTerminal(terminal);
        return "redirect:/terminals";
    }

    @GetMapping("terminals/search")
   public String searchTerminal(Model model, Terminal terminal){
        try{
            Terminal exisitingTerminal = terminalService.findTerminal(terminal.getTerminalId());
            model.addAttribute("terminal", exisitingTerminal);
        }
        catch (NoSuchElementException exception){
            String errorMessage = "Terminal Not Found!";
            model.addAttribute("error", errorMessage);
            throw exception;
        }

        return "terminals";
   }

   @GetMapping("terminals/edit/{id}")
   public String editTerminalForm(@PathVariable Long id, Model model){
        model.addAttribute("terminal", terminalService.findTerminal(id));
        return "edit-terminal";
   }

   @GetMapping("terminals/{id}")
   public String deleteTerminal(@PathVariable Long id){
        terminalService.deleteTerminal(id);
        return "redirect:/terminals";
   }
}
