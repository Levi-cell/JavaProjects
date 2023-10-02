package com.api.hospital.controllers;

import com.api.hospital.models.Doctor;
import com.api.hospital.models.Patient;
import com.api.hospital.services.DoctorService;
import com.api.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ModelAndViewController {

    @Autowired
    private PatientService pacienteService;
    @Autowired
    private DoctorService doctorInterface;

    @RequestMapping(value="/patient", method= RequestMethod.GET)
    public ModelAndView getPaciente(){
        ModelAndView mv = new ModelAndView("patient");
        List<Patient> posts = pacienteService.findAll();
        mv.addObject("patient", posts);
        return mv;
    }
    @RequestMapping(value="/doctor", method= RequestMethod.GET)
    public ModelAndView getMedicos(){
        ModelAndView mv = new ModelAndView("doctor");
        List<Doctor> posts = doctorInterface.findAll();
        mv.addObject("doctor", posts);
        return mv;
    }

    @RequestMapping(value="/newDoctor", method=RequestMethod.GET)
    public String getDoctorForm(){
        return "doctor_post";
    }

    @RequestMapping(value = "/newDoctor", method = RequestMethod.POST)
    public String saveDoctor(@Valid Doctor doctor, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newDoctor";
        }
        doctorInterface.post(doctor);
        return "redirect:/doctor";
    }
    @GetMapping("doctor/{id}/delete")
    public String delete(@PathVariable Long id){
        try{
            this.doctorInterface.delete(id);
            return "redirect:/doctor";
        }catch (NullPointerException e){
            System.out.println("NÃO ENCONTRADO");
            return "redirect:/doctor";
        }


    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value="/newPatient", method=RequestMethod.GET)
    public String getPatientForm(){
        return "patient_post";
    }

    @RequestMapping(value = "/newPatient", method = RequestMethod.POST)
    public String savePatient(@Valid Patient patient, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newPatient";
        }
        pacienteService.post(patient);
        return "redirect:/patient";
    }


}
