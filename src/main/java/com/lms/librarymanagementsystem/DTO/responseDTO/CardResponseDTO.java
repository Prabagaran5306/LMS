package com.lms.librarymanagementsystem.DTO.responseDTO;

import com.lms.librarymanagementsystem.Enum.CardStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardResponseDTO {
    int id;

    Date issueDate;

    Date updatesOn;

    CardStatus cardStatus;

    String validTill;
}
