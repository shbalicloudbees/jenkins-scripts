import hudson.model.Job
import jenkins.model.Jenkins

jobs = [:]
folders = [:]

/**
 * 1- Count jobs per folder and job type
 * 2- count jobs per folder
 */
Jenkins.instance.getAllItems(Job.class).each { Job job ->

    String jobClass = job.class.simpleName
    String parentFolder = job.getParent().getFullName()
    String jobPerFolder = parentFolder+":"+jobClass

    if(!(jobPerFolder in jobs)) {
        jobs[jobPerFolder] = 0
    }
    jobs[jobPerFolder]++


    if(!(parentFolder in folders)) {
        folders[parentFolder] = 0
    }
    folders[parentFolder]++
}


/**** Print results ******/
/*
println ""
println "Count Jobs by type/folder :"
println ""

jobs.each { k, v ->
    String[] item=k.split(":");

    if(!item[0].isEmpty()){
       println "Folder name : " + item[0]
    }
     else {
        println "Folder name : root"
    }

    println "    ${item[1]}: ${v}"
}

*/

println ""
println "Count Jobs by folder:"
println ""
folders.each { k, v ->
    if(!k.isEmpty()){
        println "${k} ${v}"
    }
    else {
        println "root ${v}"
    }


}
null