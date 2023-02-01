package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transcript {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long transcriptId;
    private String transcriptNum;
@OneToOne(mappedBy = "transcript")
    private Student student;


}
