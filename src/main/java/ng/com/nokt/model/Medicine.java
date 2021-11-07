package ng.com.nokt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ng.com.nokt.repository.RegExHelper;

@Entity
@Table(name="medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	private int weight;
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
		if(RegExHelper.medicineCodeChecker(code)) {
			this.code = code;
		}else {
			System.out.print("Medicine code can only be Uppercase letters, numbers or underscore");
		}
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
