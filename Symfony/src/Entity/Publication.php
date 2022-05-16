<?php

namespace App\Entity;

use App\Repository\PublicationRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=PublicationRepository::class)
 */
class Publication
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @Groups("post:read")
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @Assert\NotBlank (message = "Le nom ne doit pas etre vide")
     * @ORM\Column(type="string", length=255, nullable=true)
     *  @Groups("post:read")
     */
    private $nom;

    /**
     * @Assert\NotBlank (message ="la description ne doit pas etre vide")
     * @Assert\Length(min=10, minMessage="La description doit au moins avoir 10 caracteres")
     * @ORM\Column(type="string", length=255)
     *  @Groups("post:read")
     */
    private $description;

    /**
     * @ORM\Column(type="string", length=255)
     *
     */
    private $image;

    /**
     * @ORM\Column(type="string", length=255)
     *  @Groups("post:read")
     */
    private $adresse;

    /**
     * @ORM\Column(type="date")
     *
     */
    private $datecreation = 'CURRENT_TIMESTAMP';

    /**
     * @ORM\OneToMany(targetEntity=Commentaire::class, mappedBy="idPublication")
     *
     */
    private $commentaires;

    function __construct() {
        $this->datecreation=new \DateTime();
        $this->commentaires = new ArrayCollection();
    }
    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(?string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getImage(): ?string
    {
        return $this->image;
    }

    public function setImage(string $image): self
    {
        $this->image = $image;

        return $this;
    }

    public function getAdresse(): ?string
    {
        return $this->adresse;
    }

    public function setAdresse(string $adresse): self
    {
        $this->adresse = $adresse;

        return $this;
    }

    public function getDatecreation(): ?\DateTimeInterface
    {
        return $this->datecreation;
    }

    public function setDatecreation(\DateTimeInterface $datecreation): self
    {
        $this->datecreation = $datecreation;

        return $this;
    }

    /**
     * @return Collection<int, Commentaire>
     */
    public function getCommentaires(): Collection
    {
        return $this->commentaires;
    }

    public function addCommentaire(Commentaire $commentaire): self
    {
        if (!$this->commentaires->contains($commentaire)) {
            $this->commentaires[] = $commentaire;
            $commentaire->setIdPublication($this);
        }

        return $this;
    }

    public function removeCommentaire(Commentaire $commentaire): self
    {
        if ($this->commentaires->removeElement($commentaire)) {
            // set the owning side to null (unless already changed)
            if ($commentaire->getIdPublication() === $this) {
                $commentaire->setIdPublication(null);
            }
        }

        return $this;
    }
}
