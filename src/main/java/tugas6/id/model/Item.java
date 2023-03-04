package tugas6.id.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tugas6")
public class Item extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "tugas6Sequence", sequenceName = "tugas6_sequence", allocationSize = 1, initialValue = 1)// untuk otomatis id
    @GeneratedValue(generator = "tugas6Sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "count")
    public Integer count;
    @Column(name = "price")
    public Integer price;
    @Column(name = "type")
    public String type;
    @Column(name = "description", columnDefinition = "text")
    public String description;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    public LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
