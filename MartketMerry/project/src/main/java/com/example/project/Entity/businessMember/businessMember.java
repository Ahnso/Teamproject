package com.example.project.Entity.businessMember;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class businessMember {
    //builder패턴을 쓰면 중요하다고 생각 되는 것들은 builder를 사용하여 관리를 하고
    //그 외 요소들은 setter로 받는다.
    //builder를 사용하면 좋은 점? null처리에 대해서 쉽다.
    //나 이외의 다른 팀원이 실행할 경우 나는 어느 부분에서 null이 생겨날지 느낄 수 있지만
    //다른 팀원들은 잘 알 수가 없기 떄문이다.

    //Entity의 튜플의 순서에 따라 들어가는 값이 달라진다.

    //@Column 여기 컬럼에 들어가는 name은 DB에 들어가는 컬럼이름임, length = 내 추측으로는 20글자 들어감, nullable = false = null X
    // unique = true는 id를 유니크 키 값으로 설정

    // @Pattern = regexp에 들어가는 것은 (?=.*[0-9]) 우선 0~9숫자만 들어갈 수 있고, (?=.*[a-z]) 영어 소문자 = a-z만 들어간다.
    // message를 적은 이유는 나중에 유효성 검사에서 만약 이 제약에 맞게 아이디를 만들지 않을 경우 메세지가 호출됨
    @Id
    @Column(name = "businessMemberId", length = 20, nullable = false, unique = true)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]).{8,16}", message = "아이디는 8~16글자이며, 영문 소문자를, 숫자를 반드시 포함시켜주세요.")
    private String businessMemberId;

    @Column(name = "businessMemberIdPassword", length = 18)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자를 포함한 특수문자를 사용하세요.")
    private String businessMemberIdPassword;

    @Column(name = "businessMemberName")
    private String businessMemberName;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Column(name = "businessMemberEmail")
    private String businessMemberEmail;

    @Column(name = "businessMemberPhone")
    @Pattern(regexp = "(?=.*[0-9]).{11}", message = "핸드폰 번호를 다시확인해주세요!.")
    private String businessMemberPhone;

    @Column(name= "businessMemberAddress", length = 50)
    private String businessMemberAddress;

    @Column(name = "businessMemberGender", length = 4)
    private String businessMemberGender;

    @Column(name = "businessMemberBirthYear")
    @Pattern(regexp = "(?=.*[0-9]).{4}", message = "생년월일을 다시 확인해주세요.")
    private String businessMemberBirthYear;

    @Column(name = "businessMemberBirthMonth")
    @Pattern(regexp = "(?=.*[0-9]).{2}", message = "생년월일을 다시 확인해주세요.")
    private String businessMemberBirthMonth;

    @Column(name = "businessMemberBirthDate")
    @Pattern(regexp = "(?=.*[0-9]).{2}", message = "생년월일을 다시 확인해주세요.")
    private String businessMemberBirthDate;


}
