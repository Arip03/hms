package com.ari.hms.core.note;

import com.ari.hms.core.patient.Patient;
import com.ari.hms.core.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;
}
