package tn.actia.testclass.migration;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import tn.actia.pfe.Pfe_App.REPO_SVN.Svn;
import tn.actia.pfe.Pfe_App.REPO_SVN.SvnRepository;
import tn.actia.pfe.Pfe_App.REPO_SVN.SvnService;
import tn.actia.pfe.Pfe_App.REPO_SVN.SvnServiceImpl;

import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RepoSvnService {
    @Mock
    SvnRepository svnRepository;
    @InjectMocks
    SvnServiceImpl svnService;


    Svn s1 = new Svn(1l,"http://testreposvn1.com","reposvn1",4,10);
    Svn s2 = new Svn(2l,"http://testreposvn2.com","reposvn2",6,15);

    @Test
    public void testRetrieveSvnRepo(){

        Mockito.when(svnRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s1));
        Svn svn1= svnService.retriveSvnRepo(1l);
        Assertions.assertNotNull(svn1);
    }

    @Test
    public void createSvnRepoTest(){

        Svn svn1 = new Svn(1l,"http://testreposvn1.com","reposvn1",4,10);
        svnService.addsvnrepo(svn1);
        verify(svnRepository,times(1)).save(svn1);
    }


}
