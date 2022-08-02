package app.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "address", "teachers", "students" })
@EqualsAndHashCode(of = "id")
@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id") // owner
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "school_id")
	private List<Teacher> teachers;

	@ManyToMany(cascade = {

			CascadeType.PERSIST,

			CascadeType.DETACH,

			CascadeType.MERGE,

			CascadeType.REFRESH })
	@JoinTable(name = "school_student",

			joinColumns = @JoinColumn(name = "school_id"),

			inverseJoinColumns = @JoinColumn(name = "student_id")

	)
	private List<Student> students;

}
