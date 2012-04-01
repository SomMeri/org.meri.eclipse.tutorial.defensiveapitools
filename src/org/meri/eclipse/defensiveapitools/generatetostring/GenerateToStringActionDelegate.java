package org.meri.eclipse.defensiveapitools.generatetostring;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.meri.eclipse.defensiveapitools.utils.EclipseConstants;

public class GenerateToStringActionDelegate implements IWorkbenchWindowActionDelegate {

  private ISelection selection;
  private IWorkbenchWindow window;

  @Override
  public void run(IAction action) {
    //this object is needed to render wizards, messages and so on 
    Shell activeShell = window.getShell();
    //get selected items or text 
    ISelection currentSelection = selection;
    //identify active GUI part
    String activePartId = getActivePartId();
    //java editor must be handled differently than view selection 
    if (EclipseConstants.JAVA_EDITOR_ID.equals(activePartId)) {
      //get edited file
      IEditorInput input = getActiveEditor().getEditorInput();
      //currentSelection now contains text selection inside input file
      //... locate class selected in that file ...
    } else {
      //currentSelection now contains all classes inside 
      //... collect all selected classes ...
    }

    System.out.println("GenerateToStringActionDelegate");
  }

  private IEditorPart getActiveEditor() {
    return window.getActivePage().getActiveEditor();
  }

  private String getActivePartId() {
    return window.getPartService().getActivePartReference().getId();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    this.selection = selection;
  }

  @Override
  public void dispose() {
  }

  @Override
  public void init(IWorkbenchWindow window) {
    this.window = window;
  }

}
