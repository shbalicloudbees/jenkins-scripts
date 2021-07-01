import hudson.model.*
 
int nonbuildable = 0;
int buildable = 0;
for (item in Hudson.instance.items)
{
  
 if(item instanceof hudson.model.Job)
  {
    
  buildable++
  if(!item.buildable)
  {
    if(item.lastBuild != null && item.lastBuild.time != "")
    {
      println(item.name + " " + item.lastBuild.time);
    }
    else
    {
     println(item.name + " " + "Never Built")
    }
    nonbuildable++
  }
}

}
println(nonbuildable)
println(buildable)
