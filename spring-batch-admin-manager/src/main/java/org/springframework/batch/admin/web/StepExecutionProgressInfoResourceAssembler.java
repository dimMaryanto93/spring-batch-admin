/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.batch.admin.web;

import org.springframework.batch.admin.domain.StepExecutionProgressInfo;
import org.springframework.batch.admin.domain.StepExecutionProgressInfoResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;


/**
 * Knows how to build a REST resource out of our domain model {@link org.springframework.batch.admin.domain.StepExecutionProgressInfo}.
 * 
 * @author Ilayaperumal Gopinathan
 * @since 2.0
 */
public class StepExecutionProgressInfoResourceAssembler extends
		ResourceAssemblerSupport<StepExecutionProgressInfo, StepExecutionProgressInfoResource> {

	public StepExecutionProgressInfoResourceAssembler() {
		super(BatchStepExecutionsController.class, StepExecutionProgressInfoResource.class);
	}

	@Override
	public StepExecutionProgressInfoResource toResource(StepExecutionProgressInfo entity) {
		return createResourceWithId(entity.getStepExecutionId(), entity, entity.getStepExecution().getJobExecutionId());
	}

	@Override
	protected StepExecutionProgressInfoResource instantiateResource(StepExecutionProgressInfo entity) {
		return new StepExecutionProgressInfoResource(entity.getStepExecution(), entity.getStepExecutionHistory(),
				entity.getEstimatedPercentComplete(), entity.isFinished(), entity.getDuration());
	}
}
