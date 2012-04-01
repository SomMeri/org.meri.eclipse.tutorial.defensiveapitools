package org.meri.eclipse.defensiveapitools.generatetostring;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;
import org.meri.eclipse.defensiveapitools.utils.EclipseConstants;

public class GenerateToStringHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    //this object is needed to render wizards, messages and so on 
    Shell activeShell = HandlerUtil.getActiveShell(event);
    //get selected items or text 
    ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
    //identify active GUI part
    String activePartId = HandlerUtil.getActivePartId(event);
    //java editor must be handled differently than view selection 
    if (EclipseConstants.JAVA_EDITOR_ID.equals(activePartId)) {
      //get edited file
      IEditorInput input = HandlerUtil.getActiveEditorInput(event);
      //currentSelection now contains text selection inside input file
      //... locate class selected in that file ...
    } else {
      //currentSelection now contains all classes inside 
      //... collect all selected classes ...
    }

    System.out.println("GenerateToStringHandler");
    return null;
  }

}
