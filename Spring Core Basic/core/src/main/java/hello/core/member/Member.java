package hello.core.member;

// 회원 클래스
public class Member {
	
	// id, 이름, 등급
	private Long id;
	private String name;
	private Grade grade;
	
	// 생성자
	public Member(Long id, String name, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	// getter, setter
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	
	
}
