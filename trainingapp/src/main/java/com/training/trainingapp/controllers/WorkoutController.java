package com.training.trainingapp.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.training.trainingapp.DTO.ExerciseDTO;
import com.training.trainingapp.DTO.WorkoutDTO;
import com.training.trainingapp.model.Exercise;
import com.training.trainingapp.model.UserEntity;
import com.training.trainingapp.model.Workout;
import com.training.trainingapp.service.ExerciseService;
import com.training.trainingapp.service.UserService;
import com.training.trainingapp.service.WorkoutService;

@Controller
public class WorkoutController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/{id}/workout-calendar")
    public String showWorkoutCallendarPage(@PathVariable("id") String id, Model model, Principal principal) {
        Optional<UserEntity> user = userService.findUserByUsername(principal.getName());
        if (user.isPresent()) {
            List<Workout> workouts = workoutService.findWorkoutsByUserId(id);
            model.addAttribute("user", user.get());
            model.addAttribute("workouts", workouts);
            // System.out.println(workouts + "Workotus");

            return "workout-calendar";
        }
        return "redirect:/user";
    }

    @GetMapping("/{id}/workout-calendar/add-workout")
    public String showAddWorkoutPage(@PathVariable("id") String id, @RequestParam("date") String date, Model model,
            Principal principal) {
        Optional<UserEntity> user = userService.findUserByUsername(principal.getName());
        if (user.isPresent()) {
            model.addAttribute("exercise", new ExerciseDTO());
            model.addAttribute("workout", new WorkoutDTO());
            model.addAttribute("user", user.get());
            model.addAttribute("selectedDate", date);
            return "add-workout";
        }
        return "redirect:/user";
    }

    @PostMapping("/{id}/workout-calendar/add-workout")
    public String sendWorkout(@PathVariable("id") String id, @ModelAttribute("workout") WorkoutDTO workoutDTO,
            Principal principal, RedirectAttributes redirectAttributes) {
        Optional<UserEntity> user = userService.findUserByUsername(principal.getName());
        if (user.isPresent()) {
            Workout workout = new Workout();

            workout.setWorkoutName(workoutDTO.getWorkoutName());
            workout.setUser(user.get()); // Povezivanje sa korisnikom
            workoutService.saveWorkout(workout); // Snimanje workout-a

            for (ExerciseDTO exerciseDTO : workoutDTO.getExercises()) {
                Exercise exercise = new Exercise();
                exercise.setExerciseName(exerciseDTO.getExerciseName());
                exercise.setReps(exerciseDTO.getReps());
                exercise.setSeries(exerciseDTO.getSeries());
                exercise.setWorkout(workout);
                exerciseService.saveExercise(exercise);
            }

            redirectAttributes.addFlashAttribute("success", "Workout added successfully!");
            return "redirect:/" + id + "/workout-calendar";
        }
        redirectAttributes.addFlashAttribute("error", "User not found");
        return "redirect:/login";
    }
}
