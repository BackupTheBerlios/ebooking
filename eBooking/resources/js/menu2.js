/**
 * @author Roman R&auml;dle
 * @version $Id: menu2.js,v 1.1 2005/10/16 18:26:57 raedler Exp $
 * @since DAPS INTRA 1.0
 */

<script language="JavaScript1.2" type="text/javascript">
/*
     (Please keep all copyright notices.)
     This script includes the navigationTree script.
     Author: Bernd Radler
*/

// function getLayer(id)
var lastID='';
var lastLink='';
var nodearray = new Array();
var linkarray = new Array();
var nodecounter=0;
var linkcounter=0;
var std_link_color='#000000';
var active_link_color='#FF0000';
var browserVersion = 3;

//ersten Nodeeintrag setzen
setNodeArray('0_0'  ,'0');

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Funktion um Elemente der Html-Seite zu holen
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function getLayer(id)
{
  if (browserVersion == 1) {
    return document.all[id]
  } else if (browserVersion == 2) {
    return document.layers[id]
  } else if (browserVersion == 3) {
    return document.getElementById(id)
  }
  return document.getElementById(id);
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Nodetabelle füllen
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function NodeItem(wgid,parent)
{
	this.obj=null;
    this.wgid=wgid;
    this.parent=parent;
}

function setNodeArray(wgid,parent)
{
    nodearray[nodecounter++]=new NodeItem(wgid,parent);
    setLinkArray('l_'+wgid,parent)
}

function getNodeItem(wgid)
{
    var ii=0;
    //Tabelleneintrag suchen
    while(nodearray[ii])
    {
        if(nodearray[ii].wgid==wgid)
        {
            if(ii==0)
                return null;
            return nodearray[ii];
        }
        
        ii++;
    }
    return null;
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Linktabelle füllen
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function LinkItem(wgid,parent)
{
	this.obj=null;
    this.wgid=wgid;
    this.parent=parent;
}

function setLinkArray(wgid,parent)
{
    linkarray[linkcounter++]=new LinkItem(wgid,parent);
}

function getLinkItem(wgid)
{
    var ii=0;
    //Tabelleneintrag suchen
    while(linkarray[ii])
    {
        if(linkarray[ii].wgid==wgid)
        {
            if(ii==0)
                return null;
            return linkarray[ii];
        }

        ii++;
    }
    return null;
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Auf Node clicken
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// show/hide layer
function ClickNode(wgid) // mouse-click hides or shows the layer
{
	var item=getNodeItem(wgid);

    if(item)
    {
        if(!item.obj)
            item.obj=getLayer(item.wgid);

        if(lastID)
        {
            olditem=lastID;

            //Eltern Node schliessen solange es Eltern gibt
            while(olditem)
            {
                //alte Node schliessen falls alte Node nicht Parent ist
        	    if(  (item.parent != olditem.wgid)
        	       ||(item.parent==0))
        	    {
                    if(!olditem.obj)
                        olditem.obj=getLayer(olditem.wgid);

                    if(olditem.obj)
        		        olditem.obj.style.display='none';
        	    }
        	    else
        	        break

              	olditem=getNodeItem(olditem.parent);
            }
        }

    	item.obj.style.display='block';
    	lastID=item;
        item.obj.style.color='#ffffff'

    	//ClickLink('l_'+wgid);
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Auf Link clicken
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function ClickLink(actuallink)
{
    var obj=getLayer(actuallink);

    if(!obj.obj)
        obj.obj=getLayer(obj.wgid);

    if(lastLink != '')
    {
        var oldobj=getLayer(lastLink);

        if(!oldobj.obj)
            oldobj.obj=getLayer(oldobj.wgid);

        if(oldobj)
            oldobj.style.color=std_link_color;
    }

    if(obj)
    {
        obj.style.color=active_link_color;
        lastLink=actuallink;
    }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//bestimmtes Link öffnen
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function OpenLink(shop,wgid)
{
    var ii=1;
    var obj;

    if(obj=getLinkItem('l_'+shop+'_'+wgid))
    {
        ii=1;
        //alle Nodes schliessen
        while(nodearray[ii])
        {
            if(!nodearray[ii].obj)
                nodearray[ii].obj=getLayer(nodearray[ii].wgid);
            nodearray[ii].obj.style.display='none';
            ii++;
        }

        //Node für angegebenen Link öffnen

            //Überprüfen ob aktueller Link auch ein Node ist
            if(tempNode=getNodeItem(shop+'_'+wgid))
            {
                if(!tempNode.obj)
                    tempNode.obj=getLayer(tempNode.wgid);
                tempNode.obj.style.display='block';
                lastID=tempNode
            }

            ParentNode=getNodeItem(obj.parent)

            //Eltern Node öffnen
            while(ParentNode)
            {
                if(!ParentNode.obj)
                    ParentNode.obj=getLayer(ParentNode.wgid);

                ParentNode.obj.style.display='block';
                if(!lastID)
                    lastID=ParentNode;

              	ParentNode=getNodeItem(ParentNode.parent);
            }

    	ClickLink('l_'+shop+'_'+wgid);
    }
}
</script>

