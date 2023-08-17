package repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Question {
    private String name;
    private String positiveAnswer;
    private String negativeAnswer;
    private String urlImg;
}
