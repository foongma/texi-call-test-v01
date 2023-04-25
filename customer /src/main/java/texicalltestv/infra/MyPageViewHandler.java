package texicalltestv.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import texicalltestv.config.kafka.KafkaProcessor;
import texicalltestv.domain.*;

@Service
public class MyPageViewHandler {

    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCalled_then_CREATE_1(@Payload Called called) {
        try {
            if (!called.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setCallId(called.getId());
            myPage.setUserLocation(called.getUserlocation());
            myPage.setDestination(called.getDestination());
            myPage.setStatus(호출);
            myPage.setUserId(called.getUserId());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_1(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                accepted.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(accepted.getStatus());
                myPage.setTaxiNumber(accepted.getNumber());
                myPage.setTaxiModel(accepted.getModel());
                myPage.setDriverName(accepted.getDriverName());
                myPage.setDriverMobileNumber(accepted.getDriverMobileNumber());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDepartured_then_UPDATE_2(@Payload Departured departured) {
        try {
            if (!departured.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                departured.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(departured.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBoardinged_then_UPDATE_3(@Payload Boardinged boardinged) {
        try {
            if (!boardinged.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                boardinged.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(boardinged.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenArrivaled_then_UPDATE_4(@Payload Arrivaled arrivaled) {
        try {
            if (!arrivaled.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                arrivaled.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(arrivaled.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymented_then_UPDATE_5(@Payload Paymented paymented) {
        try {
            if (!paymented.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                paymented.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(paymented.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointSaved_then_UPDATE_6(@Payload PointSaved pointSaved) {
        try {
            if (!pointSaved.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByUserId(
                pointSaved.getUserId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPoint(pointSaved.getPoint());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCommentSaved_then_UPDATE_7(
        @Payload CommentSaved commentSaved
    ) {
        try {
            if (!commentSaved.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByCallId(
                commentSaved.getCallId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setComment(commentSaved.getComment());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
