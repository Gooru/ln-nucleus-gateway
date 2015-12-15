package org.gooru.nucleus.gateway.routes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RouteConfiguration implements Iterable<RouteConfigurator> {

  private List<RouteConfigurator> configurators = null;
  private Iterator<RouteConfigurator> internalIterator;
  
  @Override
  public Iterator<RouteConfigurator> iterator() {
    Iterator<RouteConfigurator> iterator = new Iterator() {

      @Override
      public boolean hasNext() {
        return internalIterator.hasNext();
      }

      @Override
      public Object next() {
        return internalIterator.next();
      }
      
    };
    return iterator;
  }
  
  public RouteConfiguration() {
    configurators = new ArrayList<RouteConfigurator>();
    configurators.add(new RouteInternalConfigurator());
    configurators.add(new RouteMetricsConfigurator());
    configurators.add(new RouteResourceConfigurator());
    internalIterator = configurators.iterator();
  }


}
