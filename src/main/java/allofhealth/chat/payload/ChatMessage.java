package allofhealth.chat.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ChatMessage {

    private int id;
    private String sender;
    private String receiver;
    private String message;
    private String timestamp;
    private Long roomNum;

}
