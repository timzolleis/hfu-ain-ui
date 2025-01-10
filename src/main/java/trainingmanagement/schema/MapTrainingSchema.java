package trainingmanagement.schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapTrainingSchema extends Schema {
    private String training;
    private String type;


    @Override
    protected void validateFields() {
        if (this.training.isEmpty()) {
            this.addError("Training is required");
        }
        if (this.type.isEmpty()) {
            this.addError("Type is required");
        }
        //Type must be either "Attend" or "Complete"
        if (!this.type.equals("Attend") && !this.type.equals("Complete")) {
            this.addError("Type must be either 'Attend' or 'Complete'");
        }
    }
}
