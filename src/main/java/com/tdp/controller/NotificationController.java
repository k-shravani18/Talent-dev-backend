package com.tdp.controller;

import com.tdp.exception.NotificationNotFoundException;
import com.tdp.model.Notification;
import com.tdp.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/getNotificationById/{id}")
    public Optional<Notification> getNotificationById(@PathVariable Long id){
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/getAllNotifications")
    public List<Notification> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

    @PostMapping("/createNotification")
    public Notification createNotification(@RequestBody Notification notification){
        return notificationService.createNotification(notification);
    }

    @PutMapping("/editNotification/{id}")
    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification updatedNotification) throws NotificationNotFoundException {
        return notificationService.updateNotification(id, updatedNotification);
    }

    @DeleteMapping("/deleteNotification/{id}")
    public void deleteNotification(@PathVariable Long id){
        notificationService.deleteNotification(id);
    }
}
