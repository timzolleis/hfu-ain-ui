package trainingmanagement.schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteTrainingMappingSchema extends Schema {

    private String training;

    @Override
    protected void validateFields() {
        if (this.training.isEmpty()) {
            this.addError("Training is required");
        }
    }
}
