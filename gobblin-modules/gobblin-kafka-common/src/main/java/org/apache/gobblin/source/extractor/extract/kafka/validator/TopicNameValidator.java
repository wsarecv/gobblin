/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.gobblin.source.extractor.extract.kafka.validator;

import org.apache.gobblin.configuration.SourceState;
import org.apache.gobblin.source.extractor.extract.kafka.KafkaTopic;

/**
 * A topic validator that validates the topic name
 */
public class TopicNameValidator extends TopicValidatorBase {
  private static final String DOT = ".";

  public TopicNameValidator(SourceState sourceState) {
    super(sourceState);
  }

  /**
   * Check if a topic name is valid, current rules are:
   *  1. must not contain "."
   * @param topic the topic to be validated
   * @return true if the topic name is valid (aka. doesn't contain ".")
   */
  @Override
  public boolean validate(KafkaTopic topic) {
    return !topic.getName().contains(DOT);
  }
}
