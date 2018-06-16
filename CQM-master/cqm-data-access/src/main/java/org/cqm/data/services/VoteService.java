package org.cqm.data.services;

import org.cqm.data.entity.Vote;
import org.cqm.data.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("voteService")
public class VoteService {

    @Autowired
    VoteRepository voteRepository;

    public VoteRepository getVoteRepository() {
        return this.voteRepository;
    }

    public boolean voteExists(String login, Integer reportId) {
        if (voteRepository.findVoteByReportAndUser(login, reportId).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void saveAndDecrement(Vote vote, Integer authorId) {
        getVoteRepository().save(vote);
        getVoteRepository().decrementUserRating(authorId);
        getVoteRepository().decrementReportRating(vote.getReportId());
    }

    public void saveAndIncrement(Vote vote, Integer authorId) {
        getVoteRepository().save(vote);
        getVoteRepository().incrementUserRating(authorId);
        getVoteRepository().incrementReportRating(vote.getReportId());
    }
}
