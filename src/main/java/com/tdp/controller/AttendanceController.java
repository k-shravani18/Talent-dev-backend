package com.tdp.controller;

import com.tdp.exception.AttendanceNotFoundException;
import com.tdp.model.Attendance;
import com.tdp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/getAttendanceById/{id}")
    public Optional<Attendance> getAttendanceById(@PathVariable Long id){
        return attendanceService.getAttendanceById(id);
    }

    @GetMapping("/getAllAttendances")
    public List<Attendance> getAllAttendances(){
        return attendanceService.getAllAttendances();
    }

    @PostMapping("/createAttendance")
    public Attendance createAttendance(@RequestBody Attendance attendance){
        return attendanceService.createAttendance(attendance);
    }

    @PutMapping("/editAttendance/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance updatedAttendance) throws AttendanceNotFoundException {
        return attendanceService.updateAttendance(id, updatedAttendance);
    }

    @DeleteMapping("/deleteAttendance/{id}")
    public void deleteAttendance(@PathVariable Long id){
        attendanceService.deleteAttendance(id);
    }
}
