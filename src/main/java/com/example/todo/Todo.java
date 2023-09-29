package com.example.todo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    
    @Id
    @SequenceGenerator(name = "todo_seq", initialValue = 1110, allocationSize = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    @Column(name = "todo_item_id", updatable = false, nullable = false)
    @Getter
    @Setter
    private long TodoId;

    @NotBlank
    @Size(min = 5, message = "A Description should have at least 5 characters")
    @Column(name = "todo_title")
    @Getter
    @Setter
    private String todoTitle;

    @NotBlank
    @Size(min = 5, message = "A Description should have at least 5 characters")
    @Column(name = "todo_description")
    @Getter
    @Setter
    private String todoDescription;


    @Column(name = "is_complete")
    @Getter
    @Setter
    private boolean isComplete;

    @FutureOrPresent
    @Column(name = "todo_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date todoDate;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss" )
    @CreationTimestamp
    @Getter
    @Setter
    private Date creationDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss" )
    @UpdateTimestamp
    @Getter
    @Setter
    private Date updateDate;

}
