package GFG.DigitalLibraryProject.Digital.Library.Project.entity.output;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Builder
@Table(name="book")
public class BookOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id",nullable = false)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "author",nullable = false)
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "published_data")
    private Instant publishedData;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
    //This is referred to as an output entity

    //TODO:Revisit this
//    private String genre;
}
