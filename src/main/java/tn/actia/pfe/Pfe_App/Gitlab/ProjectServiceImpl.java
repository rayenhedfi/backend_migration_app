package tn.actia.pfe.Pfe_App.Gitlab;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.Pager;
import org.gitlab4j.api.models.Branch;
import org.gitlab4j.api.models.Tag;
import org.gitlab4j.api.models.Visibility;
//mport org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import tn.actia.pfe.Pfe_App.BrancheGitlab.Branche;
import tn.actia.pfe.Pfe_App.BrancheGitlab.BrancheRepository;
import org.gitlab4j.api.Pager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    BrancheRepository brancheRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;


    }
    //GitLabApi gitLabApi = new GitLabApi("https://your-gitlab-url.com", project.getToken());
 /*@Override
 public Project saveProject(Project project) {
 // Create a GitLabApi instance using your GitLab server URL and personal access token
 GitLabApi gitLabApi = new GitLabApi("https://gitlab.com", project.getToken());

 // Create a GitLab4J Project instance and set its properties
 org.gitlab4j.api.models.Project projectSpec = new org.gitlab4j.api.models.Project();
 projectSpec.setName(project.getName());
 projectSpec.setDescription(project.getDescription());
 projectSpec.setVisibility(Visibility.valueOf(project.getVisibility().toString()));
 projectSpec.setIssuesEnabled(true);
 projectSpec.setMergeRequestsEnabled(true);
 projectSpec.setWikiEnabled(true);

 // Create the project in GitLab using the GitLab4J API
 try {
 org.gitlab4j.api.models.Project createdProject = gitLabApi.getProjectApi().createProject(projectSpec);

 // Set the properties of the saved project entity
 project.setId(createdProject.getId());

 // Save the project entity
 return projectRepository.save(project);
 } catch (GitLabApiException e) {
 // Handle any exceptions or errors
 e.printStackTrace();
 return null;
 }
 }
*/
    @Override
    public Project saveProject(Project project) {
        // Create a GitLabApi instance using your GitLab server URL and personal access token
        GitLabApi gitLabApi = new GitLabApi("https://gitlab.com", project.getToken());

        // Create a GitLab4J Project instance and set its properties
        org.gitlab4j.api.models.Project projectSpec = new org.gitlab4j.api.models.Project();
        projectSpec.setName(project.getName());
        projectSpec.setDescription(project.getDescription());
        projectSpec.setVisibility(Visibility.valueOf(project.getVisibility().toString()));
        projectSpec.setIssuesEnabled(true);
        projectSpec.setMergeRequestsEnabled(true);
        projectSpec.setWikiEnabled(true);

        // Create the project in GitLab using the GitLab4J API
        try {
            org.gitlab4j.api.models.Project createdProject = gitLabApi.getProjectApi().createProject(projectSpec);

            // Set the properties of the saved project entity
            project.setId(createdProject.getId());
            project.setGitlabProjectId(createdProject.getId()); // Set the GitLab project ID

            // Save the project entity
            return projectRepository.save(project);
        } catch (GitLabApiException e) {
            // Handle any exceptions or errors
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

 /* @Override
 public List<Project> getAllProject() {
 return projectRepository.findAll();
 }*/

    @Override
    public void deleteProjectInfoById(Long id) {
        projectRepository.deleteById(id);

    }
 /* @Override
 public List<Project> getAllProject() {
 try {
 List<Project> projects = new ArrayList<>();

 // Retrieve all projects from the database
 List<Project> dbProjects = projectRepository.findAll();

 // Create a GitLabApi instance using your GitLab server URL and personal access token
 GitLabApi gitLabApi = new GitLabApi("https://gitlab.com", dbProjects.get(0).getToken());

 // Get the list of projects from GitLab using the GitLab4J API
 List<org.gitlab4j.api.models.Project> gitLabProjects = gitLabApi.getProjectApi().getProjects();

 // Convert the GitLab projects to your entity projects
 for (org.gitlab4j.api.models.Project gitLabProject : gitLabProjects) {
 Project project = new Project();
 project.setId(gitLabProject.getId());
 project.setName(gitLabProject.getName());
 project.setDescription(gitLabProject.getDescription());
 // Set other project properties if needed
 projects.add(project);
 }

 // Return the combined list of projects
 projects.addAll(dbProjects);
 return projects;
 } catch (GitLabApiException e) {
 // Handle any exceptions or errors
 e.printStackTrace();
 return Collections.emptyList();
 }
 }*/


    /*@Override
    public List<Project> listGitLabProjects(String token, String userId) {
    try {
    // Endpoint URL for listing projects
    String endpointUrl = "https://gitlab.com/api/v4/users/" + userId + "/projects";

    // Create a RestTemplate instance
    RestTemplate restTemplate = new RestTemplate();

    // Set the GitLab personal access token in the Authorization header
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + token);
    HttpEntity<String> entity = new HttpEntity<>(headers);

    // Send a GET request to the GitLab API to retrieve the list of projects
    ResponseEntity<Project[]> response = restTemplate.exchange(endpointUrl, HttpMethod.GET, entity, Project[].class);

    // Retrieve the list of projects from the response body
    Project[] projectsArray = response.getBody();

    // Convert the array of projects to a list
    List<Project> gitLabProjects = Arrays.asList(projectsArray);

    // Return the list of GitLab projects
    return gitLabProjects;
    } catch (RestClientException e) {
    e.printStackTrace();
    // Handle any exceptions or errors
    return Collections.emptyList();
    }
    }*/
 /* @Override
 public List<Project> listGitLabProjects(String token, String userId) {
 try {
 // Endpoint URL for listing projects
 String endpointUrl = "https://gitlab.com/api/v4/users/" + userId + "/projects";

 // Create a RestTemplate instance
 RestTemplate restTemplate = new RestTemplate();

 // Set the GitLab personal access token in the Authorization header
 HttpHeaders headers = new HttpHeaders();
 headers.set("Authorization", "Bearer " + token);
 HttpEntity<String> entity = new HttpEntity<>(headers);

 // Send a GET request to the GitLab API to retrieve the list of projects
 ResponseEntity<Project[]> response = restTemplate.exchange(endpointUrl, HttpMethod.GET, entity, Project[].class);

 // Retrieve the list of projects from the response body
 Project[] projectsArray = response.getBody();

 // Convert the array of projects to a list
 List<Project> gitLabProjects = Arrays.asList(projectsArray);

 // Create a GitLabApi instance using the provided token
 GitLabApi gitLabApi = new GitLabApi("https://gitlab.com", token);

 // Add the number of branches and tags for each project
 for (Project project : gitLabProjects) {
 // Retrieve the number of branches using the GitLab4J API
 List<Branch> branches = gitLabApi.getRepositoryApi().getBranches(project.getId());
 int numberOfBranches = branches != null ? branches.size() : 0;

 // Retrieve the number of tags using the GitLab4J API
 List<Tag> tags = gitLabApi.getTagsApi().getTags(project.getId());
 int numberOfTags = tags != null ? tags.size() : 0;

 // Set the number of branches and tags for the project
 project.setNumberOfBranches(numberOfBranches);
 project.setNumberOfTags(numberOfTags);
 project.setGitlabProjectId(project.getId());
 }

 // Return the list of GitLab projects with the number of branches and tags
 return gitLabProjects;
 } catch (RestClientException e) {
 e.printStackTrace();
 // Handle any exceptions or errors
 return Collections.emptyList();
 } catch (GitLabApiException e) {
 throw new RuntimeException(e);
 }
 }*/
    @Override
    public List<Project> listGitLabProjects(String token, String userId) {
        try {
            // Endpoint URL for listing projects for a specific user
            String endpointUrl = "https://gitlab.com/api/v4/users/" + userId + "/projects";

            // Create a RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

            // Set the GitLab personal access token in the Authorization header
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Send a GET request to the GitLab API to retrieve the list of projects for the user
            ResponseEntity<Project[]> response = restTemplate.exchange(endpointUrl, HttpMethod.GET, entity, Project[].class);

            // Retrieve the list of projects from the response body
            Project[] projectsArray = response.getBody();

            // Convert the array of projects to a list
            List<Project> gitLabProjects = Arrays.asList(projectsArray);

            // Update and save the projects in the database
            for (Project project : gitLabProjects) {
                Long gitLabProjectId = project.getId();
                project.setGitlabProjectId(gitLabProjectId);
                project.setUserId(userId);
                project.setToken(token);
                project.setNumberOfBranches(project.getNumberOfBranches());
                project.setNumberOfTags(project.getNumberOfTags());
            }
            projectRepository.saveAll(gitLabProjects);

            // Return the list of GitLab projects
            return gitLabProjects;
        } catch (RestClientException e) {
            e.printStackTrace();
            // Handle any exceptions or errors
            return Collections.emptyList();
        }
    }



 /*@Override
 public List<Project> getAllProject() {
 try {
 List<Project> projects = new ArrayList<>();

 // Retrieve all projects from the database
 List<Project> dbProjects = projectRepository.findAll();

 // Create a GitLabApi instance using your GitLab server URL and personal access token
 GitLabApi gitLabApi = new GitLabApi("https://gitlab.com", dbProjects.get(0).getToken());

 // Get the pager for projects from GitLab using the GitLab4J API
 Pager<org.gitlab4j.api.models.Project> pager = gitLabApi.getProjectApi().getProjects(5); // Fetch 10 projects per page

 while (pager.hasNext()) {
 List<org.gitlab4j.api.models.Project> nextPage = pager.next();
 for (org.gitlab4j.api.models.Project gitLabProject : nextPage) {
 Project project = new Project();
 project.setId(gitLabProject.getId());
 project.setName(gitLabProject.getName());
 project.setDescription(gitLabProject.getDescription());
 // Set other project properties if needed
 projects.add(project);
 }
 }

 // Add the projects from the database to the list
 projects.addAll(dbProjects);
 return projects;
 } catch (GitLabApiException e) {
 // Handle any exceptions or errors
 e.printStackTrace();
 return Collections.emptyList();
 }
 }*/


    /* @Transactional
    public void assignBrancheToProject(Long id, Branche branche) {
    Project project =projectRepository.findById(id).orElse(null);
    branche.setProject(project);
    brancheRepository.save(branche);
    }*/
    @Override
    public void assignBrancheToProject(Long id, Branche branche) {
        Project project = projectRepository.findById(id).orElse(null);
        branche.setProject(project);

        // Récupérer le gitlabProjectId du projet
        Long gitlabProjectId = project.getGitlabProjectId();

        // Utiliser le gitlabProjectId pour créer la branche dans le projet GitLab
        if (gitlabProjectId != null) {
            // Utiliser GitLabApi pour créer la branche dans le projet GitLab
            GitLabApi gitLabApi = new GitLabApi("https://gitlab.com", project.getToken());
            try {
                gitLabApi.getRepositoryApi().createBranch(gitlabProjectId, branche.getBrancheNom(), branche.getBrancheRef());
            } catch (GitLabApiException e) {
                e.printStackTrace();
                // Gérer les exceptions ou erreurs éventuelles
            }
        }

        // Sauvegarder la branche dans la base de données
        brancheRepository.save(branche);
    }
    /* @Override
    public Project getProjectById(Long id) {
    Project project = projectRepository.findById(id).orElse(null);
    if (project != null) {
    project.setToken(null); // Ignorer l'attribut token lors de la réponse
    }
    return project;
    }

    @Override
    public List<Project> getAllProject() {
    List<Project> projects = projectRepository.findAll();
    for (Project project : projects) {
    project.setToken(null); // Ignorer l'attribut token lors de la réponse
    }
    return projects;
    }*/
    @Override
    public void createBranch(String gitlabToken, Long gitlabProjectId, String branchName, String branchRef) {
        // Créez une instance de GitLabApi en utilisant le token
        GitLabApi gitLabApi = new GitLabApi("https://gitlab.com", gitlabToken);

        // Utilisez GitLabApi pour créer la branche dans le projet GitLab
        try {
            gitLabApi.getRepositoryApi().createBranch(gitlabProjectId, branchName, branchRef);
        } catch (GitLabApiException e) {
            e.printStackTrace();
            // Gérez les exceptions ou les erreurs éventuelles
        }
    }




}