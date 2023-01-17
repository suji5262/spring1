package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//@Primary // SampleDAO 객체가 하나 이상일때 쓰고 싶은 클래스를 지정해줌
@Qualifier("event")
public class EvenSampleDAOImpl implements SampleDAO{

}
