package TestProject.entities;

import lombok.Data;

@Data
public class Messages {

    private int id;
    private int clientId;
    private String clientName;
    private String text;
}
