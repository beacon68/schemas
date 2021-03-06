/*
 * Copyright 2015 Open mHealth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openmhealth.schema.domain.omh;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.serializer.SerializationConstructor;

import java.math.BigDecimal;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * A number of steps.
 *
 * @author Emerson Farrugia
 * @version 2.0
 * @see <a href="http://www.openmhealth.org/documentation/#/schema-docs/schema-library/schemas/omh_step-count">step-count</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(SnakeCaseStrategy.class)
public class StepCount2 extends Measure {

    public static final SchemaId SCHEMA_ID = new SchemaId(OMH_NAMESPACE, "step-count", "2.0");

    private BigDecimal stepCount;
    private DescriptiveStatisticDenominator descriptiveStatisticDenominator;


    @SerializationConstructor
    protected StepCount2() {
    }

    public static class Builder extends Measure.TimeIntervalEffectiveTimeFrameBuilder<StepCount2, Builder> {

        private BigDecimal stepCount;
        private DescriptiveStatisticDenominator descriptiveStatisticDenominator;

        public Builder(BigDecimal stepCount, TimeFrame effectiveTimeFrame) {

            super(effectiveTimeFrame);

            checkNotNull(stepCount, "A step count hasn't been specified.");
            this.stepCount = stepCount;
        }

        public Builder(BigDecimal stepCount, TimeInterval effectiveTimeInterval) {
            this(stepCount, new TimeFrame(effectiveTimeInterval));
        }

        public Builder(double stepCount, TimeFrame effectiveTimeFrame) {
            this(BigDecimal.valueOf(stepCount), effectiveTimeFrame);
        }

        public Builder(double stepCount, TimeInterval effectiveTimeInterval) {
            this(BigDecimal.valueOf(stepCount), effectiveTimeInterval);
        }

        public Builder(long stepCount, TimeFrame effectiveTimeFrame) {
            this(BigDecimal.valueOf(stepCount), effectiveTimeFrame);
        }

        public Builder(long stepCount, TimeInterval effectiveTimeInterval) {
            this(BigDecimal.valueOf(stepCount), effectiveTimeInterval);
        }

        public Builder setDescriptiveStatisticDenominator(DescriptiveStatisticDenominator denominator) {
            this.descriptiveStatisticDenominator = denominator;
            return this;
        }

        @Override
        public StepCount2 build() {
            return new StepCount2(this);
        }
    }

    private StepCount2(Builder builder) {
        super(builder);

        this.stepCount = builder.stepCount;
        this.descriptiveStatisticDenominator = builder.descriptiveStatisticDenominator;
    }

    public BigDecimal getStepCount() {
        return stepCount;
    }

    public DescriptiveStatisticDenominator getDescriptiveStatisticDenominator() {
        return descriptiveStatisticDenominator;
    }

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        StepCount2 that = (StepCount2) o;

        return Objects.equals(stepCount, that.stepCount) &&
                descriptiveStatisticDenominator == that.descriptiveStatisticDenominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stepCount, descriptiveStatisticDenominator);
    }
}
