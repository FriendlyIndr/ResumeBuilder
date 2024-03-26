document.addEventListener('DOMContentLoaded', function() {
    const saveButton = document.querySelector('.btn');
    saveButton.addEventListener('click', saveResume);

    // Function to save the resume data
    function saveResume() {
        const resumeData = collectResumeData(); // Collect data from input fields
        sendResumeData(resumeData); // Send data to backend server
    }

    // Function to collect resume data from input fields
    function collectResumeData() {
        const personalInfo = {
            name: document.querySelector('input[name="name"]').value,
            title: document.querySelector('input[name="title"]').value,
            description: document.querySelector('textarea[name="description"]').value
        };

        const contactInfo = {
            email: document.querySelector('input[name="email"]').value,
            phone: document.querySelector('input[name="phone"]').value,
            location: document.querySelector('input[name="location"]').value,
            link1: document.querySelector('input[name="link1"]').value,
            link2: document.querySelector('input[name="link2"]').value
        };

        // Collect other sections data similarly

        const resumeData = {
            personalInfo: personalInfo,
            contactInfo: contactInfo,
            // Add other sections data here
        };

        return resumeData;
    }

    // Function to send resume data to backend server
    function sendResumeData(resumeData) {
        fetch('backend_url', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(resumeData)
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(data => {
            console.log('Resume data sent successfully:', data);
            // Handle success response
        })
        .catch(error => {
            console.error('Error sending resume data:', error);
            // Handle error
        });
    }

    // Function to add a new work experience item
    function addWorkExperience() {
        const workExperienceSection = document.querySelector('.work-experience');
        const newWorkExperienceItem = document.createElement('div');
        newWorkExperienceItem.classList.add('work-experience-item');
        newWorkExperienceItem.innerHTML = `
            <div>Title: <input type="text" name="work-title"></div>
            <div>Company: <input type="text" name="work-company"></div>
            <div>Tenure: <input type="text" name="work-tenure"></div>
            <div>Description: <textarea name="work-description"></textarea></div>
        `;
        workExperienceSection.appendChild(newWorkExperienceItem);
    }

    // Event listener for adding a new work experience item
    const addWorkExperienceButton = document.querySelector('.add-work-experience');
    addWorkExperienceButton.addEventListener('click', addWorkExperience);

    // Function to add a new skill
    function addSkill() {
        const skillsSection = document.querySelector('.skills');
        const newSkillItem = document.createElement('div');
        newSkillItem.classList.add('skill-item');
        newSkillItem.innerHTML = `
            <input type="text" name="skill" placeholder="Skill">
        `;
        skillsSection.appendChild(newSkillItem);
    }

    // Event listener for adding a new skill
    const addSkillButton = document.querySelector('.add-skill');
    addSkillButton.addEventListener('click', addSkill);

    // Function to add a new project
    function addProject() {
        const projectsSection = document.querySelector('.projects');
        const newProjectItem = document.createElement('div');
        newProjectItem.classList.add('project-item');
        newProjectItem.innerHTML = `
            <div>Name: <input type="text" name="project-name"></div>
            <div>Tools: <input type="text" name="project-tools"></div>
            <div>Description: <textarea name="project-description"></textarea></div>
        `;
        projectsSection.appendChild(newProjectItem);
    }

    // Event listener for adding a new project
    const addProjectButton = document.querySelector('.add-project');
    addProjectButton.addEventListener('click', addProject);

    // Function to add a new education
    function addEducation() {
        const educationSection = document.querySelector('.education');
        const newEducationItem = document.createElement('div');
        newEducationItem.classList.add('education-item');
        newEducationItem.innerHTML = `
            <div>Degree Name: <input type="text" name="degree-name"></div>
            <div>Course Name: <input type="text" name="course-name"></div>
            <div>Period: <input type="text" name="period"></div>
        `;
        educationSection.appendChild(newEducationItem);
    }

    // Event listener for adding a new education
    const addEducationButton = document.querySelector('.add-education');
    addEducationButton.addEventListener('click', addEducation);
});
