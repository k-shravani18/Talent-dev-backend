package com.tdp.service;

import com.tdp.exception.AttendanceNotFoundException;
import com.tdp.model.Attendance;
import com.tdp.model.Trainee;
import com.tdp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Optional<Attendance> getAttendanceById(Long id){
        return attendanceRepository.findById(id);
    }

    public List<Attendance> getAllAttendances(){
        return attendanceRepository.findAll();
    }

    public Attendance createAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) throws AttendanceNotFoundException {
        Optional<Attendance> existingAttendance = attendanceRepository.findById(id);

        if (existingAttendance.isPresent()) {
            Attendance attendance = existingAttendance.get();
            attendance.setTrainee(updatedAttendance.getTrainee());
            attendance.setDate(updatedAttendance.getDate());
            attendance.setPresent(updatedAttendance.isPresent());
            return attendanceRepository.save(attendance);
        } else {
            throw new AttendanceNotFoundException();
        }
    }

    public void deleteAttendance(Long id){
        attendanceRepository.deleteById(id);
    }
}
