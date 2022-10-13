/*******************************************************************************
 * Copyright (C) 2022 DFKI GmbH
 * Author: Gerhard Sonnenberg (gerhard.sonnenberg@dfki.de)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
package de.dfki.cos.basys.aas.registry.service.tests;

import org.assertj.core.api.Assertions;
import de.dfki.cos.basys.aas.registry.service.storage.elasticsearch.PainlessElasticSearchScripts;
import de.dfki.cos.basys.aas.registry.service.storage.elasticsearch.ResourceLoadingException;
import org.junit.Test;

public class PainlessElasticSearchScriptsTest {

	@Test
	public void whenUnknownResourceRequested_thenThrowException() {
		PainlessElasticSearchScripts scripts = new PainlessElasticSearchScripts();
		Assertions.assertThatExceptionOfType(ResourceLoadingException.class).isThrownBy(() -> scripts.loadResourceAsString("unknown"));
	}

	@Test
	public void whenStoreResourcesRequested_thenSuccess() {
		PainlessElasticSearchScripts scripts = new PainlessElasticSearchScripts();
		Assertions.assertThat(scripts.loadResourceAsString(PainlessElasticSearchScripts.STORE_ASSET_ADMIN_SUBMODULE)).isNotEmpty();
	}

	@Test
	public void whenRemoveResourcesRequested_thenSuccess() {
		PainlessElasticSearchScripts scripts = new PainlessElasticSearchScripts();
		Assertions.assertThat(scripts.loadResourceAsString(PainlessElasticSearchScripts.REMOVE_ASSET_ADMIN_SUBMODULE)).isNotEmpty();
	}
}