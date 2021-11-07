package ng.com.nokt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp="^[a-zA-Z_-]*$", message="Medicine Name can only contain Alphabets, numbers, dash(-) or underscore(_)")
	@Column(name="name")
	private String name;
	
	private int weight;
	
	@Pattern(regexp="^[a-zA-Z0-9_]*$", message="Medicine code can only contain Uppercase letters, numbers or underscore(_)")
	private String code;
	
	@Column(name="img_url")
	private String imgUrl;

	public Medicine(String name, int weight, String code, String imgUrl) {
		super();
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.imgUrl = imgUrl;
	}

	public Medicine() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
