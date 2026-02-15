import javafx.fxml.FXML;
import javafx.scene.control.*;

public class QuizController {

    @FXML TextField studentIdField;
    @FXML Label questionLabel;
    @FXML RadioButton opt1,opt2,opt3,opt4;

    ToggleGroup group = new ToggleGroup();

    String studentID;
    int qIndex = 0;
    int score = 0;

    String[] questions = {
        "আলোর বেগ কত?",
        "বল = ?"
    };

    String[][] options = {
        {"3×10⁸ m/s","3×10⁶ m/s","3×10⁵ m/s","3×10⁷ m/s"},
        {"ভর × ত্বরণ","ভর × বেগ","শক্তি × সময়","চাপ × ক্ষেত্রফল"}
    };

    int[] answers = {0,0};

    @FXML
    void startQuiz() throws Exception {

        studentID = studentIdField.getText();

        if(!StudentDAO.validateStudent(studentID)){
            new Alert(Alert.AlertType.ERROR,
                    "Invalid Student ID").show();
            return;
        }

        opt1.setToggleGroup(group);
        opt2.setToggleGroup(group);
        opt3.setToggleGroup(group);
        opt4.setToggleGroup(group);

        loadQuestion();
    }

    void loadQuestion(){
        questionLabel.setText(questions[qIndex]);
        opt1.setText(options[qIndex][0]);
        opt2.setText(options[qIndex][1]);
        opt3.setText(options[qIndex][2]);
        opt4.setText(options[qIndex][3]);
    }

    @FXML
    void nextQuestion() throws Exception {

        RadioButton selected =
                (RadioButton) group.getSelectedToggle();

        if(selected != null){
            int index = switch(selected.getText()){
                case "3×10⁸ m/s","ভর × ত্বরণ" -> 0;
                case "3×10⁶ m/s","ভর × বেগ" -> 1;
                case "3×10⁵ m/s","শক্তি × সময়" -> 2;
                default -> 3;
            };

            if(index == answers[qIndex])
                score++;
        }

        qIndex++;

        if(qIndex < questions.length)
            loadQuestion();
        else{
            ScoreDAO.saveScore(studentID, score);
            new Alert(Alert.AlertType.INFORMATION,
                    "Quiz Finished! Score = "+score).show();
        }
    }
}
