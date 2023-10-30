package com.tdp.service;

import com.tdp.exception.NotificationNotFoundException;
import com.tdp.model.Notification;
import com.tdp.model.Trainee;
import com.tdp.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Optional<Notification> getNotificationById(Long id){
        return notificationRepository.findById(id);
    }

    public List<Notification> getAllNotifications(){
        return notificationRepository.findAll();
    }

    public Notification createNotification(Notification notification){
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification updatedNotification) throws NotificationNotFoundException {
        Optional<Notification> existingNotification = notificationRepository.findById(id);

        if (existingNotification.isPresent()) {
            Notification notification = existingNotification.get();
            notification.setMessage(updatedNotification.getMessage());
//            notification.setTrainee(updatedNotification.getTrainee());
            notification.setDateTime(updatedNotification.getDateTime());
            return notificationRepository.save(notification);
        } else {
            throw new NotificationNotFoundException();
        }
    }

    public void deleteNotification(Long id){
        notificationRepository.deleteById(id);
    }
}
