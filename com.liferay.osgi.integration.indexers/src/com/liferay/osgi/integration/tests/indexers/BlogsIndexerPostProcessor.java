package com.liferay.osgi.integration.tests.indexers;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexerPostProcessor;

@Component(
	immediate = true,
	property = {
		"indexer.class.name=com.liferay.portlet.blogs.util.BlogsIndexer"
	},
	service = IndexerPostProcessor.class
)
public class BlogsIndexerPostProcessor extends BaseIndexerPostProcessor {

	@Override
	public void postProcessDocument(Document document, Object obj)
			throws Exception {
		super.postProcessDocument(document, obj);
	}
	
}
